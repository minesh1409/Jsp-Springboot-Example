 $(window).on('load', function(){       
       
	 scanChart();
	 downloadChart();
        
    }); //end windowload
 
 function scanChart(){
	 
	 var createdAt = [];  var totalCount= [];
     
     // executes when complete page is fully loaded, including all frames, objects and images
     $.getJSON('/analysischart', function(data) {			
     	 $.each(data, function(index, value) {         		 
             if($.inArray(value.createdAt.substring(0, 10), createdAt) == -1)
             {
                 createdAt.push(value.createdAt.substring(0, 10).substring(0, 10));
             }
         });
     	 
     	$.each(createdAt, function(index, countCreatedAt) {
             var i=0;
             $.each(data, function(index, value) {
                 if(value.createdAt.substring(0, 10) == countCreatedAt){
                     i++;                       
                 }
             });
             
             totalCount.push(i);                
         });     /*Total Scane/Day */
     	
         createdAt.unshift("x");
         totalCount.unshift("Total Scan");  
     })
     
     .done(function() {
         console.log( "second success" );
         timeSeriesChart();                 
     })
         .fail(function() {
         alert( "Server error : 500" );
     })
         .always(function() {
         console.log( "finished" );
         
     });
     
     function timeSeriesChart(){
         // Timeseries Chart
         c3.generate({
             bindto: '#chart-time',
             data: {
                 x: 'x',
                 // xFormat: '%Y%m%d', // 'xFormat' can be used as custom format of 'x'
                 columns: [
                     createdAt,
                     // ['x', '20130101', '20130102', '20130103', '20130104', '20130105', '20130106'],
                     totalCount,
                 ]
             },
             axis: {
                 x: {
                     type: 'category',
                     tick: {
                         format: '%Y-%m-%d',
                         centered: true
                     }
                 }
             },
             grid: {
                 x: {
                     show: !1
                 },
                 y: {
                     show: !0
                 }
             }
         });
     }
	 
 }
 
 function downloadChart(){
	 
	 var createdAt = [];  var totalCount= [];
     
     // executes when complete page is fully loaded, including all frames, objects and images
     $.getJSON('/downloadchart', function(data) {
    	 
     	 $.each(data, function(index, value) {         		 
             if($.inArray(value.createdAt.substring(0, 10), createdAt) == -1)
             {
                 createdAt.push(value.createdAt.substring(0, 10).substring(0, 10));
             }
         });
     	 
     	$.each(createdAt, function(index, countCreatedAt) {
             var i=0;
             $.each(data, function(index, value) {
                 if(value.createdAt.substring(0, 10) == countCreatedAt){
                     i++;                       
                 }
             });
             
             totalCount.push(i);                
         });     /*Total Scane/Day */
     	
         createdAt.unshift("x");
         totalCount.unshift("Total Download");  
     })
     
     .done(function() {
         console.log( "second success" );
         downloadTimeSeriesChart();                 
     })
         .fail(function() {
         alert( "Server error : 500" );
     })
         .always(function() {
         console.log( "finished" );
         
     });
     
     function downloadTimeSeriesChart(){
         // Timeseries Chart
         c3.generate({
             bindto: '#chart-time-download',
             data: {
                 x: 'x',
                 // xFormat: '%Y%m%d', // 'xFormat' can be used as custom format of 'x'
                 columns: [
                     createdAt,
                     // ['x', '20130101', '20130102', '20130103', '20130104', '20130105', '20130106'],
                     totalCount,
                 ]
             },
             axis: {
                 x: {
                     type: 'category',
                     tick: {
                         format: '%Y-%m-%d',
                         centered: true
                     }
                 }
             },
             grid: {
                 x: {
                     show: !1
                 },
                 y: {
                     show: !0
                 }
             }
         });
     }
	 
 }