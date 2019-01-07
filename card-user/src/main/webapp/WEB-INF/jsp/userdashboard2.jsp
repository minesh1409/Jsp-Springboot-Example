<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@include file="header.jsp" %>
<%@include file="sidebar.jsp" %>
 
 <div class="block-header">
        <div class="row">
            <div class="col-lg-5 col-md-8 col-sm-12">                        
                <h2>Anaysis</h2>
            </div>            
            <div class="col-lg-7 col-md-4 col-sm-12 text-right">
                <ul class="breadcrumb justify-content-end">
                    <li class="breadcrumb-item"><a href="index.php"><i class="icon-home"></i></a></li>                            
                    <li class="breadcrumb-item active">View</li>
                    <!--<li class="breadcrumb-item active">Table Normal</li>-->
                </ul>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-lg-12">
            <div class="card text-center">
                <div class="body">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-6">
                            <img id="qrimage"  src="https://chart.googleapis.com/chart?chs=100x100&cht=qr&chl=http://spectaindia.in"/>
                            <div  style="position: relative;bottom: 15px;">Your Qr </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-6">
                            <div class="body">
                                <i class="fa fa-eye fa-2x"></i>
                                <h4 id="postView">...</h4>
                                <span>Post View</span>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-6">
                            <div class="body">
                                <i class="fa fa-globe fa-2x"></i>
                                <h4 id="uniqueCountry">...</h4>
                                <span>Country</span>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-6">
                            <div class="body">
                                <i class="fa fa-map-marker fa-2x"></i>
                                <h4 id="uniqueCity">...</h4>
                                <span>City</span>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>




    <div class="row clearfix">

        <div class="col-lg-6 col-md-6 col-sm-12">
            <div class="card">
                <div class="header">
                    <h2>Timeseries Chart</h2>
                </div>
                <div class="body">
                    <div id="chart-time"></div>
                </div>
            </div>
        </div>


        <div class="col-lg-6 col-md-6 col-sm-12">
            <div class="card">
                <div class="header">
                    <h2>Simple Pie Chart</h2>
                </div>
                <div class="body">
                    <div id="pie-chart" class="ct-chart"></div>
                </div>
            </div>
        </div>

    </div>


    <div class="row clearfix">
        <div class="col-lg-12 col-md-12 col-sm-12">
            <div class="card">
                <div class="header">
                    <h2>World Map</h2>
                </div>
                <div class="body">
                    <div id="world-map-markers" class="jvector-map" style="height: 300px"></div>
                </div>
            </div>
        </div>
    </div>


    <div class="row clearfix">
        <div class="col-lg-12">
            <div class="card">


                <div class="header">
                    <h2>Analysis Your Card <small> Detail Of Visited User</small> </h2>                            
                </div>
                <div class="row clearfix">
                    <div class="col-lg-6">
                        <button id="loder" class="btn btn-primary" disabled="disabled" style="display:none"><i class="fa fa-spinner fa-spin"></i><span>Loading...</span></button>
                    </div>

                    <div id="totaldiv" style="display:none">
                        <div class="col-lg-6">
                            <div class="body">
                                <div class="form-group" style=" width: 200px;">
                                    <div class="float-left">
                                        <i class="fa fa-2x fa-bar-chart-o text-col-green"></i>
                                        <h6 id="totalvisited">Total Visit :</h6>
                                        <!--<span id="totalCount" class="font700"></span>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div> <!--clearfix-->


                <div class="body table-responsive">



                    <table class="table" id="exampleTable" class="dataTable" role="grid" aria-describedby="exampleTable_info">
                        <thead>
                            <tr>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >#</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >PHONE</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >IP</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >OS</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >BROWSER</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >CITY</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >STATE</th>
                                <th class="sorting" tabindex="0" aria-controls="exampleTable" rowspan="1" colspan="1" aria-label="Name: activate to sort column ascending" >COUNTRY</th>
                            </tr>
                        </thead>
                        <tbody id="tableBody" >
                            <!-- Dynamic Generate data for Analysis-->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>



    </div>

 

<!--9480129564042646-->

<!-- Javascript  Pi Chart-->
<script src="../assets/vendor/chartist/polar_area_chart.js"></script><!-- Polar Area Chart Js -->
<!--<script src="assets/js/pages/charts/chartjs.js"></script>-->

<script>




</script>



<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script>
    function getTableData(){
        $.getJSON('http://www.spectaindia.in/connect_city/get_card_analysis.php?cardId='+sessionStorage.cardId, function(data) {
            //var checkdata=JSON.stringify(data);
            var dataLength=data.card_analysis.length;
            var showData=data.card_analysis;

            var row ;
            for(i=0;i<dataLength;i++){
                /*(function(index) {
                    setTimeout(function() { */
                //GetAddress(showData[index].latitude,showData[index].longitude);
               /* $.ajax({
                    type: "GET",
                    url: "http://maps.googleapis.com/maps/api/geocode/json?latlng="+data.card_analysis[i].latitude+","+data.card_analysis[i].longitude+"&sensor=true",
                    async: false,
                    success : function(data) {*/
                        //console.log(data.results[1].formatted_address);
                        row = $('<tr role="row" ></tr>').appendTo($("#tableBody"));
                        $('<td style="white-space: normal"></td>').text(i+1).appendTo(row); //scope="row"
                        $('<td style="white-space: normal"></td>').text(showData[i].mobile).appendTo(row); 
                        $('<td style="white-space: normal"></td>').text(showData[i].ip_address).appendTo(row); 
                        $('<td style="white-space: normal"></td>').text(showData[i].os).appendTo(row); 
                        $('<td style="white-space: normal"></td>').text(showData[i].browser).appendTo(row); 
                        //$('<td style="white-space: normal"></td>').text(data.results[1].formatted_address).appendTo(row);
                        $('<td style="white-space: normal"></td>').text(showData[i].city).appendTo(row); 
                        $('<td style="white-space: normal"></td>').text(showData[i].state).appendTo(row); 
                        $('<td style="white-space: normal"></td>').text(showData[i].country).appendTo(row);
                   /* },error : function(response) {
                        console.log("Error:"+response);
                    }
                });*/

                /*      }, i * 1000);
                })(i);
*/
            }

            $('#exampleTable').DataTable({
                'elemsPerPage': 5,
                "pagingType": "full_numbers"
            });

        });


    }
</script> <!--Get Table data-->

<script type="text/javascript"> //Geo location
    function GetAddress(lt,ln) {
        var lat = parseFloat(lt);
        var lng = parseFloat(ln);
        var latlng = new google.maps.LatLng(lat, lng);
        var geocoder = geocoder = new google.maps.Geocoder();
        geocoder.geocode({ 'latLng': latlng }, function (results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[1]) {
                    //sessionStorage.geoAddress = results[1].formatted_address;
                    console.log(results[1].formatted_address);
                }
            }
        });

    }
</script> <!--::: Geo Location from latitude longitude  ::: -->


<script>
    $(window).on('load', function(){ 
        if ($(window).width() < 761) {
            $('#exampleTable').removeClass('table dataTable no-footer');
        }
    });
</script>


<script>
    $(window).on('load', function(){ 
        var uniqueCountry = [];  var uniqueCity= [];
        var uniqueOs= [];  var osCount = [];
        var createdAt = [];  var uniqueCount = [];  var totalCount= [];
        //var clean = [];

        // executes when complete page is fully loaded, including all frames, objects and images
        $.getJSON('http://www.spectaindia.in/connect_city/get_card_analysis.php?cardId='+sessionStorage.cardId, function(data) {
            $.each(data.card_analysis, function(index, value) {
                if($.inArray(value.country, uniqueCountry) == -1)
                {
                    uniqueCountry.push(value.country);
                    //clean.push(value);
                }
                if($.inArray(value.city, uniqueCity) == -1)
                {
                    uniqueCity.push(value.city);
                    //clean.push(value);
                } 
                if($.inArray(value.os, uniqueOs) == -1)
                {
                    uniqueOs.push(value.os);
                    //clean.push(value);
                }              
                /*if(value.os.indexOf("Windows")!= -1) 
                {
                    osWindows++;
                }*/

                if($.inArray(value.created_at.substring(0, 10), createdAt) == -1)
                {
                    createdAt.push(value.created_at.substring(0, 10));
                }

            });     /* Unique Country City Os Created At */
            $.each(uniqueOs, function(index, valueOs) {
                var i=0;
                $.each(data.card_analysis, function(index, value) {
                    if(value.os== valueOs){
                        i++;                       
                    }
                });
                osCount.push(i);
            });             /* Unique Os Count */

            $.each(createdAt, function(index, valueCreatedAt) {
                var i=0;
                $.each(data.card_analysis, function(index, value) {
                    if(value.created_at.substring(0, 10) == valueCreatedAt){
                        i++;                       
                    }
                });
                totalCount.push(i);                
            });     /*Total Scane/Day */
            createdAt.unshift("x");
            totalCount.unshift("Total Scan");

            jsonObj = [];
            $.each(uniqueCountry, function(index, valueCountry) {
                var i =0;
                $.each(data.card_analysis, function(index, value) {
                    if(value.country == valueCountry){
                        item = {}
                        item ["latLng"] = [ JSON.parse(value.latitude), JSON.parse(value.longitude)];
                        item ["name"] = valueCountry+" : "+ ++i;
                    }
                });

                jsonObj.push(item);
            });     /* Map */


            jsonCountry = {"BD": "Bangladesh", "BE": "Belgium", "BF": "Burkina Faso", "BG": "Bulgaria", "BA": "Bosnia and Herzegovina", "BB": "Barbados", "WF": "Wallis and Futuna", "BL": "Saint Barthelemy", "BM": "Bermuda", "BN": "Brunei", "BO": "Bolivia", "BH": "Bahrain", "BI": "Burundi", "BJ": "Benin", "BT": "Bhutan", "JM": "Jamaica", "BV": "Bouvet Island", "BW": "Botswana", "WS": "Samoa", "BQ": "Bonaire, Saint Eustatius and Saba ", "BR": "Brazil", "BS": "Bahamas", "JE": "Jersey", "BY": "Belarus", "BZ": "Belize", "RU": "Russia", "RW": "Rwanda", "RS": "Serbia", "TL": "East Timor", "RE": "Reunion", "TM": "Turkmenistan", "TJ": "Tajikistan", "RO": "Romania", "TK": "Tokelau", "GW": "Guinea-Bissau", "GU": "Guam", "GT": "Guatemala", "GS": "South Georgia and the South Sandwich Islands", "GR": "Greece", "GQ": "Equatorial Guinea", "GP": "Guadeloupe", "JP": "Japan", "GY": "Guyana", "GG": "Guernsey", "GF": "French Guiana", "GE": "Georgia", "GD": "Grenada", "GB": "United Kingdom", "GA": "Gabon", "SV": "El Salvador", "GN": "Guinea", "GM": "Gambia", "GL": "Greenland", "GI": "Gibraltar", "GH": "Ghana", "OM": "Oman", "TN": "Tunisia", "JO": "Jordan", "HR": "Croatia", "HT": "Haiti", "HU": "Hungary", "HK": "Hong Kong", "HN": "Honduras", "HM": "Heard Island and McDonald Islands", "VE": "Venezuela", "PR": "Puerto Rico", "PS": "Palestinian Territory", "PW": "Palau", "PT": "Portugal", "SJ": "Svalbard and Jan Mayen", "PY": "Paraguay", "IQ": "Iraq", "PA": "Panama", "PF": "French Polynesia", "PG": "Papua New Guinea", "PE": "Peru", "PK": "Pakistan", "PH": "Philippines", "PN": "Pitcairn", "PL": "Poland", "PM": "Saint Pierre and Miquelon", "ZM": "Zambia", "EH": "Western Sahara", "EE": "Estonia", "EG": "Egypt", "ZA": "South Africa", "EC": "Ecuador", "IT": "Italy", "VN": "Vietnam", "SB": "Solomon Islands", "ET": "Ethiopia", "SO": "Somalia", "ZW": "Zimbabwe", "SA": "Saudi Arabia", "ES": "Spain", "ER": "Eritrea", "ME": "Montenegro", "MD": "Moldova", "MG": "Madagascar", "MF": "Saint Martin", "MA": "Morocco", "MC": "Monaco", "UZ": "Uzbekistan", "MM": "Myanmar", "ML": "Mali", "MO": "Macao", "MN": "Mongolia", "MH": "Marshall Islands", "MK": "Macedonia", "MU": "Mauritius", "MT": "Malta", "MW": "Malawi", "MV": "Maldives", "MQ": "Martinique", "MP": "Northern Mariana Islands", "MS": "Montserrat", "MR": "Mauritania", "IM": "Isle of Man", "UG": "Uganda", "TZ": "Tanzania", "MY": "Malaysia", "MX": "Mexico", "IL": "Israel", "FR": "France", "IO": "British Indian Ocean Territory", "SH": "Saint Helena", "FI": "Finland", "FJ": "Fiji", "FK": "Falkland Islands", "FM": "Micronesia", "FO": "Faroe Islands", "NI": "Nicaragua", "NL": "Netherlands", "NO": "Norway", "NA": "Namibia", "VU": "Vanuatu", "NC": "New Caledonia", "NE": "Niger", "NF": "Norfolk Island", "NG": "Nigeria", "NZ": "New Zealand", "NP": "Nepal", "NR": "Nauru", "NU": "Niue", "CK": "Cook Islands", "XK": "Kosovo", "CI": "Ivory Coast", "CH": "Switzerland", "CO": "Colombia", "CN": "China", "CM": "Cameroon", "CL": "Chile", "CC": "Cocos Islands", "CA": "Canada", "CG": "Republic of the Congo", "CF": "Central African Republic", "CD": "Democratic Republic of the Congo", "CZ": "Czech Republic", "CY": "Cyprus", "CX": "Christmas Island", "CR": "Costa Rica", "CW": "Curacao", "CV": "Cape Verde", "CU": "Cuba", "SZ": "Swaziland", "SY": "Syria", "SX": "Sint Maarten", "KG": "Kyrgyzstan", "KE": "Kenya", "SS": "South Sudan", "SR": "Suriname", "KI": "Kiribati", "KH": "Cambodia", "KN": "Saint Kitts and Nevis", "KM": "Comoros", "ST": "Sao Tome and Principe", "SK": "Slovakia", "KR": "South Korea", "SI": "Slovenia", "KP": "North Korea", "KW": "Kuwait", "SN": "Senegal", "SM": "San Marino", "SL": "Sierra Leone", "SC": "Seychelles", "KZ": "Kazakhstan", "KY": "Cayman Islands", "SG": "Singapore", "SE": "Sweden", "SD": "Sudan", "DO": "Dominican Republic", "DM": "Dominica", "DJ": "Djibouti", "DK": "Denmark", "VG": "British Virgin Islands", "DE": "Germany", "YE": "Yemen", "DZ": "Algeria", "US": "United States", "UY": "Uruguay", "YT": "Mayotte", "UM": "United States Minor Outlying Islands", "LB": "Lebanon", "LC": "Saint Lucia", "LA": "Laos", "TV": "Tuvalu", "TW": "Taiwan", "TT": "Trinidad and Tobago", "TR": "Turkey", "LK": "Sri Lanka", "LI": "Liechtenstein", "LV": "Latvia", "TO": "Tonga", "LT": "Lithuania", "LU": "Luxembourg", "LR": "Liberia", "LS": "Lesotho", "TH": "Thailand", "TF": "French Southern Territories", "TG": "Togo", "TD": "Chad", "TC": "Turks and Caicos Islands", "LY": "Libya", "VA": "Vatican", "VC": "Saint Vincent and the Grenadines", "AE": "United Arab Emirates", "AD": "Andorra", "AG": "Antigua and Barbuda", "AF": "Afghanistan", "AI": "Anguilla", "VI": "U.S. Virgin Islands", "IS": "Iceland", "IR": "Iran", "AM": "Armenia", "AL": "Albania", "AO": "Angola", "AQ": "Antarctica", "AS": "American Samoa", "AR": "Argentina", "AU": "Australia", "AT": "Austria", "AW": "Aruba", "IN": "India", "AX": "Aland Islands", "AZ": "Azerbaijan", "IE": "Ireland", "ID": "Indonesia", "UA": "Ukraine", "QA": "Qatar", "MZ": "Mozambique"};

            jsonObjCountry = {};
            $.each(uniqueCountry, function(index, valueCountry) {
                $.each(jsonCountry, function(index, jsonCountry) {
                    if(valueCountry==jsonCountry){
                        console.log(index);
                        jsonObjCountry[index] = "#18ce0f";
                        //jsonObjCountry.push();
                    }
                }); 
            }); 

            $("#postView").text(data.card_analysis.length);
            $("#uniqueCountry").text(uniqueCountry.length);
            $("#uniqueCity").text(uniqueCity.length);


            /*timeSeriesChart();
            
            var target = "Windows";
            var numOccurences = $.grep(arr, function (elem) {
                return elem === target;
            }).length;
            pieChart();
            worldMap();*/
            getTableData();
        })
        .done(function() {
            console.log( "second success" );
            timeSeriesChart();
            pieChart();
            worldMap();
            
        })
            .fail(function() {
            alert( "Server error : 500" );
        })
            .always(function() {
            console.log( "finished" );
            
        });

        function pieChart(){
            var dataPie = {
                series: osCount
            };
            var labels = uniqueOs;
            var sum = function(a, b) {
                return a + b;
            };
            new Chartist.Pie('#pie-chart', dataPie, {
                height: "320px",
                labelInterpolationFnc: function(value, idx) {
                    var percentage = Math.round(value / dataPie.series.reduce(sum) * 100) + '%';
                    return labels[idx] + ' (' + percentage + ')';
                }
            });
        };

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

        function worldMap(){
            if( $('#world-map-markers').length > 0 ){

                $('#world-map-markers').vectorMap(
                    {
                        map: 'world_mill_en',
                        backgroundColor: 'transparent',
                        borderColor: '#fff',
                        borderOpacity: 0.25,
                        borderWidth: 0,
                        color: '#e6e6e6',
                        regionStyle : {
                            initial : {
                                fill : '#cccccc'
                            },
                            hover: { fill: '#72b17a' }
                        },

                        markerStyle: {
                            initial: {
                                r: 5,
                                'fill': '#fff',
                                'fill-opacity':1,
                                'stroke': '#000',
                                'stroke-width' : 1,
                                'stroke-opacity': 0.4
                            }
                        },

                        markers : jsonObj,

                        series: {
                            regions: [
                                {
                                    values: jsonObjCountry,
                                    /*{
                                        "US": '#18ce0f',
                                        "IN": '#18ce0f',

                                    },*/
                                    attribute: 'fill'
                                }]
                        },
                        hoverOpacity: null,
                        normalizeFunction: 'linear',
                        zoomOnScroll: false,
                        scaleColors: ['#000000', '#000000'],
                        selectedColor: '#000000',
                        selectedRegions: [],
                        enableZoom: false,
                        hoverColor: '#fff',

                    });
                
            }
        }


    }); //end windowload

    $(document).ready(function(){
        
            $("#qrimage").attr("src","https://chart.googleapis.com/chart?chs=100x100&cht=qr&chl=http://spectaindia.in/connect_city/");
        
    });


</script> <!-- Color active/deactive  on sidebar-->

<%@include file="footer.jsp" %>