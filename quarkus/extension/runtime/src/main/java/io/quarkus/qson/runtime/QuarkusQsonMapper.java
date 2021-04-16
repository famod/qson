package io.quarkus.qson.runtime;

import io.quarkus.qson.GenericType;
import io.quarkus.qson.parser.ByteArrayParserContext;
import io.quarkus.qson.parser.QsonParser;
import io.quarkus.qson.writer.ByteArrayJsonWriter;
import io.quarkus.qson.writer.JsonByteWriter;
import io.quarkus.qson.writer.QsonObjectWriter;
import io.quarkus.qson.writer.OutputStreamJsonWriter;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;

/**
 * Graal-safe mapper that doesn't use reflection or bytecode generation.
 * Expects that Quarkus has scanned and generated needed bytecode at build time and has registered
 * these mappers at static initialization.
 *
 * All parsers and writers are found by a String key lookup.  The key is just the fully-qualified class name
 * unless it is a generic, then, in that case the String key is generated by {@link io.quarkus.qson.util.Types#typename(Type)}
 *
 */
@ApplicationScoped
public class QuarkusQsonMapper {

    public QsonParser parserFor(String typename) {
        return QuarkusQsonRegistry.getParser(typename);
    }
    public QsonObjectWriter writerFor(String typename) {
        return QuarkusQsonRegistry.getWriter(typename);
    }
}
