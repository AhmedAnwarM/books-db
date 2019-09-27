package com.elmasarany.utility;

import com.elmasarany.books.entity.Book;
import com.elmasarany.utility.exception.DiskReadException;
import com.elmasarany.utility.exception.DiskWriteException;
import com.elmasarany.utility.exception.WrongPathException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import static com.elmasarany.utility.JsonUtilities.convertFromJson;
import static com.elmasarany.utility.JsonUtilities.convertToJson;
import static java.util.logging.Level.SEVERE;

/**
 * @author Ahmed El Masarany
 */
public class DiskUtils {
    private static final Logger LOGGER = Logger.getLogger(DiskUtils.class.getName());
    private static final String FILE_PATH = "/home/aanwar/Desktop/books.json";

    public static Set<Book> readFromDisk() throws DiskReadException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            Book[] books = convertFromJson(builder.toString(), Book[].class);
            return new HashSet<>(Arrays.asList(books));
        } catch (FileNotFoundException e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            throw new WrongPathException("Wrong path to database file " + FILE_PATH, e);
        } catch (IOException e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            throw new DiskReadException("Failed to read books from database file " + FILE_PATH, e);
        }
    }

    public static void writeToDisk(Collection<Book> books) throws DiskWriteException {
        try (FileWriter fw = new FileWriter(FILE_PATH, false)) {
            String json = convertToJson(books);
            fw.write(json);
        } catch (JsonProcessingException e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            throw new WrongPathException("Wrong path to database file " + FILE_PATH, e);
        } catch (IOException e) {
            LOGGER.log(SEVERE, e.getMessage(), e);
            throw new DiskWriteException("Failed to write books to database file " + FILE_PATH, e);
        }
    }
}
