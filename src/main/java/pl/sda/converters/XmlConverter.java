package pl.sda.converters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlConverter implements Converter {

    @Override
    public <T> T convert(String xmlString, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            return (T) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

}
