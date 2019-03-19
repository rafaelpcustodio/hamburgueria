package br.com.dextra.hamburgueria.common.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Class responsible for manipulating the data related to a JSON object.
 *
 * @author rafaelcustodio
 */
public final class JSONUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Prevents the class to be instantiated.
     */
    private JSONUtil() {
    }

    /**
     * Read a certain JSON file and map its value to a certain bean type.
     *
     * @param path The of the file to be read.
     * @param type The {@link JavaType} used for the conversion.
     * @return The representation of the file content as a bean.
     * @throws IOException Error while reading the json file.
     */
    public static Object fileToBean(final String path, final JavaType type) throws IOException {
        final File file = new File(JSONUtil.class.getClass().getResource(path).getPath());
        return MAPPER.readValue(file, type);
    }
}
