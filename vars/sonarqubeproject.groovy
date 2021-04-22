 import groovy.json.*

 String analysis_report(String component,String metrics,String from,String to)
 {
        def conn = null
   
        def url ="http://localhost:9000/api/measures/search_history?component=${component}&metrics=${metrics}&from=${from}&to=${to}"
        conn = new URL(url).openConnection();
        conn.setRequestMethod("GET")
        conn.setRequestProperty("Authorization", "Basic YWRtaW46U2F1QDcyNzY=")
       
          def postRC = conn.getResponseCode();
        def responseText = conn.getInputStream().getText()
        JsonSlurper slurper = new JsonSlurper()
        responseText = slurper.parseText(responseText) 
       
       def measures=responseText.measures
        HashMap<String, String> story = new HashMap<String, String>();
       for( def msg in measures)
       {
           //println(msg)
           def metric=msg.metric
           def value=msg.history.value
           story.put(metric,value)
       }
       String str=""
       for(def sto in story)
       {
           str=str+sto
       }
      return str
 }