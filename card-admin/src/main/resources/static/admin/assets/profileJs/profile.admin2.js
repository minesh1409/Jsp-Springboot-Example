 $( document ).ready(function() {
        console.log( "ready!" );
        $('#cardIdTable').DataTable({
            'elemsPerPage': 5,
            "pagingType": "full_numbers"
        });
       // getCardIds();
    });

    function getCardIds(){
        var i = 1;
        $.get('http://spectaindia.in/connect_city/get_card_id.php',function(data){
            console.log("::: Getting  :::");
            $.each( data.card_ids, function( index,card ) {
                var status= (card.status == "inactive") ? '<span class="badge badge-default">'+card.status+'</span>' :'<span class="badge badge-success">'+card.status+'</span>';
                var newRow = '<tr>'+ 
                    '<td>'+i+'<input type="hidden" value='+card.id+'></td>'+
                    '<td style="padding: 0px;"><img src="https://chart.googleapis.com/chart?chs=50x50&cht=qr&chl='+card.card_link+'"  alt=""></td>'+   /*class="rounded-circle avatar"*/
                    '<td><span class="text-muted">'+card.card_link+'</span></td>'+
                    '<td>'+card.mobile+'</td>'+
                    '<td>'+status+'</td>'+  //<span class="badge badge-default">card</span>
                    '<td></td>'+
                    '</tr>';
                $(newRow).appendTo("#tbody"); 
                i++;
            });
            $('#cardIdTable').DataTable({
                'elemsPerPage': 5,
                "pagingType": "full_numbers"
            });
        },'json');
    }
    
    function refreshCardIds(){
        var i = 1;
        $.get('http://spectaindia.in/connect_city/get_card_id.php',function(data){
            console.log("::: Getting  :::");
            $.each( data.card_ids, function( index,card ) {
                var status= (card.status == "inactive") ? '<span class="badge badge-default">'+card.status+'</span>' :'<span class="badge badge-success">'+card.status+'</span>';
                var newRow = '<tr>'+ 
                    '<td>'+i+'<input type="hidden" value='+card.id+'></td>'+
                    '<td style="padding: 0px;"><img src="https://chart.googleapis.com/chart?chs=50x50&cht=qr&chl='+card.card_link+'"  alt=""></td>'+   /*class="rounded-circle avatar"*/
                    '<td><span class="text-muted">'+card.card_link+'</span></td>'+
                    '<td>'+card.mobile+'</td>'+
                    '<td>'+status+'</td>'+  //<span class="badge badge-default">card</span>
                    '<td></td>'+
                    '</tr>';
                $(newRow).appendTo("#tbody"); 
                i++;
            });
        },'json');
    }
    
    function generateCard(){
        $.ajax(
            {	
                type: "GET",
                url: "http://writte.io/php_api/add_card_id.php",
                async: false,
                success: function(response){ 
                    console.log(response);
                    window.location.replace("http://localhost/admincard/admin/cardid.php"); 
                },
                error:function(response)
                {	
                    console.log("ERROR ! "+response);
                }
            });
         console.log("response");
    }
    
    
    /* $( document ).ready(function() {
    console.log( "ready!" );
     $.ajax(
            {	
                type: "GET",
                url: "http://spectaindia.in/connect_city/get_card_id.php?phone=55555",
                async: false,
                dataType: "json",
                success: function(response){ 
                    console.log(response);

                },
                error:function(response)
                {	
                    console.log("ERROR!");
                }
            });
});*/