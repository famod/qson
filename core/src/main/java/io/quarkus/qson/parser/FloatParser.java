package io.quarkus.qson.parser;

public class FloatParser implements QsonParser {
    @Override
    public ParserState startState() {
        return ObjectParser.PARSER.startNumberValue;
    }

    @Override
    public <T> T getTarget(ParserContext ctx) {
        return (T)Float.valueOf(ctx.popFloatToken());
    }
}
