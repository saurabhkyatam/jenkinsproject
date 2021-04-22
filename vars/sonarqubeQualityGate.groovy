

def createCondition(String sonarqubehost,String error,String gateName,String metric,String op)
{
      
     
      def conn = null
      def url ="http://${sonarqubehost}/api/qualitygates/create_condition?error=${error}&gateName=${gateName}&metric=${metric}&op=${op}"
        conn = new URL(url).openConnection();
        conn.setRequestMethod("POST")
        conn.setRequestProperty("Authorization", "Basic YWRtaW46U2F1QDcyNzY=")
       
        def postRC = conn.getResponseCode();

        println( "done")
}

def updateCondition(int error,String id,String metric,String op)
{
      def conn = null
   
        def url ="http://localhost:9000/api/qualitygates/update_condition?error=${error}&id=${id}&metric=${metric}&op=${op}"
        conn = new URL(url).openConnection();
        conn.setRequestMethod("POST")
        conn.setRequestProperty("Authorization", "Basic YWRtaW46U2F1QDcyNzY=")
       
       def postRC = conn.getResponseCode();
}
def deleteCondition(String id)
{
      def conn = null
   
        def url ="http://localhost:9000/api/qualitygates/delete_condition?id=${id}"
        conn = new URL(url).openConnection();
        conn.setRequestMethod("POST")
        conn.setRequestProperty("Authorization", "Basic YWRtaW46U2F1QDcyNzY=")
       
        def postRC = conn.getResponseCode();
}