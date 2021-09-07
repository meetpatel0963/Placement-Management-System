import {
  File,
  PersonalDetails,
  EducationDetails,
  JobDetails,
  Student,
  SaveStudentRequest,
  ContactDetails,
  GetStudentContactRequest,
  GetAllStudentsRequest,
  GetStudentByIdRequest,
  DeleteStudentRequest,
  UpdateStudentRequest,
} from "./student_pb";

const studentIdDB = "1";

const studentHelper = (fileByteArray) => {
  const personalDetails = new PersonalDetails();

  const profilePicture = new File();
  profilePicture.setFilename("profilePicture");
  profilePicture.setFilesize("3243134");
  profilePicture.setFiletype("image/jpeg");
  profilePicture.setFile(fileByteArray);

  personalDetails.setProfilepicture(profilePicture);
  personalDetails.setFirstname("Firstname");
  personalDetails.setMiddlename("Middlename");
  personalDetails.setLastname("Lastname");
  personalDetails.setFathername("Fathername");
  personalDetails.setGender("Gender");
  personalDetails.setCurrentaddressline1("Currentaddressline1");
  personalDetails.setCurrentaddressline2("Currentaddressline2");
  personalDetails.setPermanentaddressline1("Permanentaddressline1");
  personalDetails.setPermanentaddressline2("Permanentaddressline2");
  personalDetails.setCity("City");
  personalDetails.setState("State");
  personalDetails.setCountry("Country");
  personalDetails.setDob("Dob");
  personalDetails.setNationality("Nationality");
  personalDetails.addArticles("Articles");

  const educationDetails = new EducationDetails();
  educationDetails.getSscdetailsMap().set("Sscdetails", "1");
  educationDetails.getHscdetailsMap().set("Hscdetails", "1");
  educationDetails.getDiplomadetailsMap().set("Diplomadetails", "1");
  educationDetails.getUgdetailsMap().set("Ugdetails", "1");
  educationDetails.getPgdetailsMap().set("Pgdetails", "1");

  const contactDetails = new ContactDetails();
  contactDetails.setPrimaryemailid("Primaryemailid");
  contactDetails.setSecondaryemailid("Secondaryemailid");
  contactDetails.setPhonenumber("Phonenumber");
  contactDetails.setAltphonenumber("Altphonenumber");
  contactDetails.setAltphonenumberbelongsto("Altphonenumberbelongsto");
  contactDetails.setLinkedinid("Linkedinid");
  contactDetails.setSkypeid("Skypeid");

  const jobDetails = new JobDetails();
  jobDetails.addSkills("Skill1");
  jobDetails.setExperiencetype("Experiencetype");
  jobDetails.setExperienceperiodinyears(2);
  jobDetails.setExperienceperiodinmonths(12);

  const student = new Student();
  student.setPersonaldetails(personalDetails);
  student.setEducationdetails(educationDetails);
  student.setContactdetails(contactDetails);
  student.setJobdetails(jobDetails);

  return student;
};

export const saveStudent = (client, fileByteArray) => {
  const student = studentHelper(fileByteArray);

  const saveStudentReq = new SaveStudentRequest();
  saveStudentReq.setStudent(student);

  client.saveStudent(saveStudentReq, null, (err, response) => {
    if (err) return console.log(err);
    const msg = response.getMessage();
    console.log(msg);
  });
};

export const getStudentContactDetails = (client) => {
  const getStudentContactRequest = new GetStudentContactRequest();
  const studentId = new GetStudentContactRequest.StudentId();
  studentId.setStudentid(studentIdDB);
  const studentidsList = [studentId];
  getStudentContactRequest.setStudentidsList(studentidsList);

  client.getStudentContactDetails(
    getStudentContactRequest,
    null,
    (err, response) => {
      if (err) return console.log(err);
      console.log(response);
    }
  );
};

export const getAllStudents = (client) => {
  const getAllStudentsRequest = new GetAllStudentsRequest();

  client.getAllStudents(getAllStudentsRequest, null, (err, response) => {
    if (err) return console.log(err);
    console.log(response);
  });
};

export const getStudentById = (client) => {
  const getStudentByIdRequest = new GetStudentByIdRequest();
  getStudentByIdRequest.setStudentid(studentIdDB);

  client.getStudentById(getStudentByIdRequest, null, (err, response) => {
    if (err) return console.log(err);
    console.log(response);
  });
};

export const updateStudent = (client) => {
  const student = studentHelper();
  student.setId(studentIdDB);

  const updateStudentRequest = new UpdateStudentRequest();
  updateStudentRequest.setStudent(student);

  client.updateStudent(updateStudentRequest, null, (err, response) => {
    if (err) return console.log(err);
    const msg = response;
    console.log(msg);
  });
};

export const deleteStudent = (client) => {
  const deleteStudentRequest = new DeleteStudentRequest();
  deleteStudentRequest.setStudentid(studentIdDB);

  client.deleteStudent(deleteStudentRequest, null, (err, response) => {
    if (err) return console.log(err);
    console.log(response);
  });
};
