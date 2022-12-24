public class BeginsWith implements IsGood<String> {
    private String prefix;
    
    public BeginsWith(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public boolean isGood(String item) {
        return item.startsWith(prefix);
    }
    
}
