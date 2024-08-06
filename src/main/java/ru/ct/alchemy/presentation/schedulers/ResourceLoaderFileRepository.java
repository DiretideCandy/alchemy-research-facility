package ru.ct.alchemy.presentation.schedulers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Repository;
import ru.ct.alchemy.model.Report;
import ru.ct.alchemy.repositories.FileRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@Repository
@AllArgsConstructor
public class ResourceLoaderFileRepository implements FileRepository {

    private final ResourceLoader resourceLoader;

    @SneakyThrows
    @Override
    public Report readRandomFile(String directoryPath)  {

        ResourcePatternResolver resolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
        Resource[] resources = resolver.getResources("classpath:" + directoryPath + "/*.json");

        List<Resource> resourceList = Arrays.stream(resources)
                .filter(Resource::exists)
                .toList();

        if (resourceList.isEmpty()) {
            throw new IOException("No files found in directory: " + directoryPath);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(resourceList.size());

        InputStream inputStream = resourceList.get(randomIndex).getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream, Report.class);
    }
}
