package ru.ct.alchemy.model.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.ct.alchemy.model.dto.DateFilterDTO;
import ru.ct.alchemy.model.dto.DateFilterStringDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Mapper
public interface DateMapper {
    DateMapper INSTANCE = Mappers.getMapper(DateMapper.class);


    @Mapping(target = "from", source = "from", qualifiedByName = "stringToDate")
    @Mapping(target = "to", source = "to", qualifiedByName = "stringToDate")
    DateFilterDTO toDate(DateFilterStringDTO dateFilterStringDTO);

    @Named("stringToDate")
    default Date stringToDate(String string) throws ParseException {
        if (string == null || string.isBlank()) return null;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return sdf.parse(string);
    }
}
