public class IsPositive implements IsGood<Integer> {

    @Override
    public boolean isGood(Integer item) {
        return item > 0;
    }
    
}
