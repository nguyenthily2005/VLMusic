package DAO;

import DTO.ArtistInfor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class ArtistInforDAO {

    public static List<ArtistInfor> parseArtists(String filePath) {
        List<ArtistInfor> artists = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("Artist");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String stageName = element.getElementsByTagName("StageName").item(0).getTextContent();
                    String realName = element.getElementsByTagName("RealName").item(0).getTextContent();
                    String birthDate = element.getElementsByTagName("BirthDate").item(0).getTextContent();
                    String hometown = element.getElementsByTagName("Hometown").item(0).getTextContent();

                    NodeList songList = element.getElementsByTagName("Song");
                    List<String> hitSongs = new ArrayList<>();
                    for (int j = 0; j < songList.getLength(); j++) {
                        hitSongs.add(songList.item(j).getTextContent());
                    }

                    ArtistInfor artist = new ArtistInfor(stageName, realName, birthDate, hometown, hitSongs);
                    artists.add(artist);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artists;
    }

}
