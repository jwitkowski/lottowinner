package pl.sda.converters;

public interface Converter {

    public <T> T convert(String string, Class<T> clazz);

}
