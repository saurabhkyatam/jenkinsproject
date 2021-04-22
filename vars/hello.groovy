def call(String temp)
{
    println "hello done ${temp}"
}

def displaymsg(String first,String last)
{
    println " ${first} --- ${last}"
}
String returndemo()
{
    return"return from script";
}
def createCondition(int error,String gateName,String metric,String op)
{
      def conn = null
   
        def url ="http://localhost:9000/api/qualitygates/create_condition?error=${error}&gateName=${gateName}&metric=${metric}&op=${op}"
        conn = new URL(url).openConnection();
        conn.setRequestMethod("Post")
        conn.setRequestProperty("Authorization", "Basic YWRtaW46U2F1QDcyNzY=")
       
       // def postRC = conn.getResponseCode();
}