$( document ).ready(function() {
	analysis();
});

function analysis(){
    var  mobile,city,ip,country,state,city,lat,log;
   
    mobile=$("#mobiletxt").val();
    
    if(mobile == '' || mobile == null){
    	
        mobile='unknown';

    }
    console.log("Mobile" + mobile);

    $.ajax({
        url: "https://geoip-db.com/jsonp",
        jsonpCallback: "callback",
        dataType: "jsonp",
        success: function( location ) {
            country=location.country_name;
            state=location.state;
            city=location.city;
            lat=location.latitude;
            log=location.longitude;
            ip=location.IPv4;
            
            $.ajax({
                type : "POST",
                url  : "/addanalysis",
                data: { 
                    mobile : mobile,
                    os:$.client.os,
                    browser:$.client.browser,
                    ip: ip,
                    country: country,
                    state: state,
                    city: city,
                    latitude: lat,
                    longitude: log,
                },
               // dataType: 'json',
                success : function(data) {
                    console.log(data);
                },
                fail: function(xhr, textStatus, errorThrown){
                    console.log(xhr);
                    console.log(textStatus);
                    console.log(errorThrown);
                }

            });//inner ajax
        }
    }); //outer Ajax


}; //end Function


$("#DownloadVcard").click(function(){
	countVcardDownload();
});

function countVcardDownload(){
   $.post('/vcfdownload',function(data){
       console.log("::: Downloaded Card :::");
       console.log(data);
   });

}
