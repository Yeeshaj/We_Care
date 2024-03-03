# We Care

# 1.Use Cases 
 
1.1 Raise Request 
whenever a user sees an injured animal login into the we care website, then under raise request section fill all the mandatory details like area name, state, city, upload the photo of an injured animal and submit the request this request, the request goes to an organization which checks the severity of the request and assign the request to a user which is present in the organization. Based on the severity and authenticity of the request the user either accepts it or rejects the request updating the status as (reject, approved), which can be seen in view status. 

Actors: End User, Organization 
 
1.2 Approve Request 
Whenever an organization receive a request it sends a request to a user. The user will check the images which are being uploaded and based on the authenticity the user will accept a reject the request. 
Actors: User under org, Organization 
 
 
1.3 Join Org 
We Care also provides the facility to an end user to join any organization, by joining an organization you will be getting request directed from an organization to help any animal. You can leave or join an Org at any time. 
Actors: End User 
 
 
1.4 Accept org Joining Request 
when a user sends a request to join an org, the request goes for the approval to an organization, the organization would then either accept or reject the request. 
Actors: Organization 
 
 
1.5 Assign user 
When an end user raises a request for help it goes to an organization, the organization then chooses to which user present in the org they want to assign. 
Actors: Organization 
 
 
1.6 Leave Org 
Any user part of any organization can leave that organization/group at anytime 
Actors: User under org 
 
 
 
 
 
 
























# Implementations 

The starting of the project is HTML page from where all the requests to JavaScript, in JavaScript there will be front end validations and after successful validation ,data will be sent to controller class, the controller class will be sending the data after encapsulating the data in to a class object ,to the content model class , in this class will first initiate database connection after initiating database connection, it do the processing of data and then send the requested data back to  controller class ,the controller class  then sends the data directly to JSP page or a  JavaScript function  who will write the data to HTML /JSP classes. 

 
    
 
# Design patterns

Creator: User and Organization, they are responsible to call the objects of different classes present in the system.
Information Expert: Since User can ask the list of the request raised, it is an example of an Expert system. Similarly, Org can also ask for the list of the approved Request.
Low Coupling: The system has been designed to reduce the impact of change in depended upon elements on dependant elements.
Controller: There are different controller assigned to preform different task as
User Controller
Org Controller
High Cohesion:  A separate class has been created to perform different functionalities and it goes as:
Controller classes to receive data from UI and encapsulation into designed class.
Content Model class: after the data is been processed in controlled class, it sends the data to CM class which initializes the Db connection and does the processing.
Bean classes: The real-life problem is demonstrated used software models know as bean classes, like User, Organization, Country.
Pure Fabrication: A pure fabrication is a class that does not represent a concept in the problem domain. userService, orgService, contentModel.



 



