$(function(){
    
    // Initialize Popup Window
    $('.open-popup-link').magnificPopup({
        type:'inline',
        midClick: true // Allow opening popup on middle mouse click. Always set it to true if you don't provide alternative source in href.
    });
    
    
    //Initialize JQuery Forms Plugin
    $('#announcementForm').ajaxForm({ 
       
        success:   processJson 
    }); 
    
    function processJson(data) { 
        //once we get a response from the server refresh the page.
        location.reload();
    }
    
    
    //On every row click of the bootstrap table, I will set the fields to the form 
    //with the id
    //if the id is not set, it means it is a create new.
     $('#announcements-table').bootstrapTable({
     }).on('click-row.bs.table', function (e, row, $element) {
                
               //selected row              
                var selectedRow = JSON.stringify(row);
                var obj = jQuery.parseJSON( selectedRow );
                setFieldsToForm(obj);
                
     }) .on('check.bs.table', function (e, row) {
                var selectedRow = JSON.stringify(row);
                var obj = jQuery.parseJSON( selectedRow );
                setFieldsToForm(obj);
     });
     
     function setFieldsToForm(row){
         $("#id").val(row.id);
         $("#title").val(row.title);
         $("#body").val(row.body);
         $("#startdate").val(row.startDate);
         $("#expirydate").val(row.expiryDate);
     }

    $("#createNewButton").click(function(){
        $("#id").val("");
        $("#title").val("");
        $("#body").val("");
        $("#expirydate").val("");
        $("#startdate").val("");
    });
    
    
    $("#delete").click(function(){
       
       var selectedRow = JSON.stringify($("#announcements-table").bootstrapTable('getSelections')); 
       
       var rowObj = eval(selectedRow);
       
       $.ajax({
             url: "http://localhost:8080/announcement/webresources/rest/"+rowObj[0].id,
             type: "delete"
             
       });
      
       location.reload();
    });
    
    
});
