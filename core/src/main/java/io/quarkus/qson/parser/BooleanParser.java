package io.quarkus.qson.parser;

public class BooleanParser implements QsonParser {
    @Override
    public ParserState startState() {
        return ObjectParser.PARSER.startBooleanValue;
    }

    @Override
    public <T> T getTarget(ParserContext ctx) {
        return (T)Boolean.valueOf(ctx.popBooleanToken());
    }
}
