/**
 * 
Author: Yeeshaj Aarshin Srivastava
 */
function joinGroup(userId,orgId)
{
	document.myForm.action = "/We_Care/MainAction.do?subaction=joinOrg&id="+userId+"&orgId="+orgId;
		document.myForm.method="POST";
		document.myForm.submit();
}

function exitGroup(userId,orgId)
{
	document.myForm.action = "/We_Care/MainAction.do?subaction=exitGroup&id="+userId+"&orgId="+orgId;
		document.myForm.method="POST";
		document.myForm.submit();
}
function logout(userId)
{
	document.myForm.action = "/We_Care/MainAction.do?subaction=logout&id="+userId;
		document.myForm.method="POST";
		document.myForm.submit();
}
function  logins()
{
	
	var id=$("#userid").val();
	var password=$("#password").val();
	//window.location.href = "/We_Care/MainAction.do?subaction=login&id="+id+"&password="+password;
		var exists=false;
		/*$.ajax({
            type: "POST",
            url: "/We_Care/MainAction.do?subaction=login&id="+id+"&password="+password,
            data: {},
            contentType: "application/json; charset=utf-8",
            dataType: "html", 
            success: function (data) {
					data=jQuery.parseJSON(data);
					if(data=='Pass')
					alert('Login Successful');
					else
					alert("Wrong Id and Password");
					
            }
           

        });*/

		document.myForm.action = "/We_Care/MainAction.do?subaction=login&id="+id+"&password="+password;
		document.myForm.method="POST";
		document.myForm.submit();
		
	
		/*document.myForm.action = "/We_Care/MainAction.do?subaction=login&id="+id+"&password="+password;
		document.myForm.submit();*/
		//return true;
}
function  raiseRequest()
{
	var stateId=$("#state").val();
	var countryId=$("#country").val();
	var cityId=$("#city").val();
	var ngo=$("#org").val();
	var area=$("#area").val();
	var description=$("#request_description").val();
	//var photo=$("#upload_images").val();
	var fileinput = document.getElementById("upload_images");
 	 var image = new SimpleImage(fileinput);
	/*$.ajax({
            type: "POST",
            url: "/We_Care//MainAction.do?subaction=raiseRequest&stateId="+stateId+"&cityId="+cityId+"&countryId="+countryId+"&ngo="+ngo+"&area="+area+"&description="+description,
            data: {},
            contentType: "application/json; charset=utf-8",
            dataType: "html",
            success: function (data) {
					//alert(data);
					data=jQuery.parseJSON(data);
					//alert(data);
					$('#org').find('option').remove().end()
						$("#org").append('<option value=0>Select NGO</option>');
					for(i=0;i<data.length;i++)
					{
						var temp=data[i].split('@');
						$("#org").append('<option value='+temp[0]+'>'+temp[1]+'</option>');
					}
                /*$.each(jQuery.parseJSON(data.d), function () {
						alert(d.val());
                    state.append($("<option></option>").val(this['FieldDescription']).html(this['FieldCode']));
                });
            },
            failure: function (response) {
                alert("Error while loading data");
            }
        });*/
		document.myForm.action = "/We_Care//MainAction.do?subaction=raiseRequest&stateId="+stateId+"&cityId="+cityId+"&countryId="+countryId+"&ngo="+ngo+"&area="+area+"&description="+description;
		document.myForm.method="POST";
		document.myForm.submit();
}
function populateNGO()
{
	var stateId=$("#state").val();
	var countryId=$("#country").val();
	var cityId=$("#city").val();
	$.ajax({
            type: "POST",
            url: "/We_Care//MainAction.do?subaction=populateNGO&stateId="+stateId+"&cityId="+cityId+"&countryId="+countryId,
            data: {},
            contentType: "application/json; charset=utf-8",
            dataType: "html",
            success: function (data) {
					//alert(data);
					data=jQuery.parseJSON(data);
					//alert(data);
					$('#org').find('option').remove().end()
						$("#org").append('<option value=0>Select NGO</option>');
					for(i=0;i<data.length;i++)
					{
						var temp=data[i].split('@');
						$("#org").append('<option value='+temp[0]+'>'+temp[1]+'</option>');
					}
                /*$.each(jQuery.parseJSON(data.d), function () {
						alert(d.val());
                    state.append($("<option></option>").val(this['FieldDescription']).html(this['FieldCode']));
                });*/
            },
            failure: function (response) {
                alert("Error while loading data");
            }
        });
}
function populateCity(stateId)
{
	$.ajax({
            type: "POST",
            url: "/We_Care//MainAction.do?subaction=retrieveCity&stateId="+stateId,
            data: {},
            contentType: "application/json; charset=utf-8",
            dataType: "html",
            success: function (data) {
					//alert(data);
					data=jQuery.parseJSON(data);
					//alert(data);
					$('#city').find('option').remove().end()
						$("#city").append('<option value=0>Select City</option>');
					for(i=0;i<data.length;i++)
					{
						var temp=data[i].split('@');
						$("#city").append('<option value='+temp[0]+'>'+temp[1]+'</option>');
					}
                /*$.each(jQuery.parseJSON(data.d), function () {
						alert(d.val());
                    state.append($("<option></option>").val(this['FieldDescription']).html(this['FieldCode']));
                });*/
            },
            failure: function (response) {
                alert("Error while loading data");
            }
        });
    }

function populateState(countryId)
{
	$.ajax({
            type: "POST",
            url: "/We_Care//MainAction.do?subaction=retrieveState&countryId="+countryId,
            data: {},
            contentType: "application/json; charset=utf-8",
            dataType: "html",
            success: function (data) {
					//alert(data);
					data=jQuery.parseJSON(data);
					//alert(data);
					$('#state').find('option').remove().end()
						$("#state").append('<option value=0>Select State</option>');
					for(i=0;i<data.length;i++)
					{
						var temp=data[i].split('@');
						$("#state").append('<option value='+temp[0]+'>'+temp[1]+'</option>');
					}
                /*$.each(jQuery.parseJSON(data.d), function () {
						alert(d.val());
                    state.append($("<option></option>").val(this['FieldDescription']).html(this['FieldCode']));
                });*/
            },
            failure: function (response) {
                alert("Error while loading data");
            }
        });
    }
