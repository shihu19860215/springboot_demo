logbak整合redis logstash，elasticsearch

logstash配置
input {
 redis {
  codec => json
  host => "192.168.2.166"
  port => 6379
  key => "logstash"
  data_type => "list"
 }
}
output {
     elasticsearch {
        hosts => ["192.168.2.166:9200"]
        index => "索引名"
        }
}
------------------------以下为范例--------------------------------
input {
     file {
        path => "/home/vagrant/logstash/logstash-2.2.2/dbpool-logs/dev/common-sql-*.log"
        start_position => "beginning"
        type => "sql"
        codec => json {
            charset => "UTF-8"
        }        
     }
     file {
        path => "/home/vagrant/logstash/logstash-2.2.2/dbpool-logs/dev/common-transaction-*.log"
        start_position => "beginning"
        type => "transaction"
        codec => json {
            charset => "UTF-8"
        }        
     }
}
output { 
    if "_grokparsefailure" in [tags] {
    }else{
        if [type] == "sql"{
                elasticsearch { 
                         hosts => ["http://192.168.33.10:9200"]
                         index => "common-sql-%{+YYYY.MM.dd}"
                }
       }
       if [type] == "transaction"{
                elasticsearch { 
                         hosts => ["http://192.168.33.10:9200"]
                         index => "common-transaction-%{+YYYY.MM.dd}"
                }
       }
    }   
}
----------------------------------------------------------------------------
