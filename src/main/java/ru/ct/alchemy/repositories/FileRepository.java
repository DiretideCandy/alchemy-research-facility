package ru.ct.alchemy.repositories;

import ru.ct.alchemy.model.Report;

import java.io.IOException;

public interface FileRepository {
    Report readRandomFile(String directoryPath) throws IOException;
}
