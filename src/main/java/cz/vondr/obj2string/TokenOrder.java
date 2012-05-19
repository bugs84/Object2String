package cz.vondr.obj2string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TokenOrder {
    private static final List<Tokens> DEFAULT_TOKENS = Arrays.asList(Tokens.FIELDS);

    private List<Tokens> tokens;

    public TokenOrder() {
        this(null);
    }

    /**
     * @param tokens if null DEFAULT_TOKENS are used
     */
    public TokenOrder(List<Tokens> tokens) {
        if (tokens == null) {
            this.tokens = new ArrayList<Tokens>(DEFAULT_TOKENS);
        } else {
            this.tokens = new ArrayList<Tokens>(tokens);
        }
    }


    public List<Tokens> getTokens() {
        return tokens;
    }

}
