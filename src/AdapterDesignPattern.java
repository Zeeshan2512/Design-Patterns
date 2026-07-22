interface IReports{
    String getJSONData(String data);
}
class XMLDataProvider{
    public String getXMLData(String data){
        int sep = data.indexOf(':');
        String name = data.substring(0, sep);
        String id   = data.substring(sep + 1);
        // Build an XML representation
        return "<user>"
                + "<name>" + name + "</name>"
                + "<id>"   + id   + "</id>"
                + "</user>";
    }
}
class XMLDataProviderAdapter implements IReports{
    private final XMLDataProvider xmlDataProvider;
    public XMLDataProviderAdapter(XMLDataProvider xmlDataProvider){
        this.xmlDataProvider = xmlDataProvider;
    }
    @Override
    public String getJSONData(String data) {
        String xml = xmlDataProvider.getXMLData(data);
        // 2. Naïvely parse out <name> and <id> values
        int startName = xml.indexOf("<name>") + 6;
        int endName   = xml.indexOf("</name>");
        String name   = xml.substring(startName, endName);

        int startId = xml.indexOf("<id>") + 4;
        int endId   = xml.indexOf("</id>");
        String id    = xml.substring(startId, endId);

        // 3. Build and return JSON
        return "{\"name\":\"" + name + "\", \"id\":" + id + "}";
    }
}
class Client{
    public  void getReportsData(IReports report, String rawData){
        System.out.println("Processed JSON:" +
                report.getJSONData(rawData));
    }
}
public class AdapterDesignPattern {
    public static void main(String[] args){
        String rawData = "Alice:42";
        XMLDataProvider xmlDataProvider = new XMLDataProvider();
        XMLDataProviderAdapter xmlDataProviderAdapter = new XMLDataProviderAdapter(xmlDataProvider);
        Client client = new Client();
        client.getReportsData(xmlDataProviderAdapter,rawData);
    }
}
