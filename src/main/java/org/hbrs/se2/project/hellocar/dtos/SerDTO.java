package org.hbrs.se2.project.hellocar.dtos;



import java.util.Date;

public interface SerDTO {

    //DTO für studentische Dienstleistungen

    //Name nicht notwendig, wenn nur über eingeloggten Student erreichbar

    public String getName();
    public String getProfession();
    public String getQualification();
    public String getPrevJobs();
    public Date getStartDate();
    public Date getEndDate();
    public String getTitle();
    public String getDescription();
    public String getCarAvailable();
    public String getDriversLicense();
    public String getWorkplace();
    public Integer getSalary();
    public String getHomeoffice();

    public void setName(String name);
    public void setProfession(String profession);
    public void setQualification(String qualification);
    public void setPrevJobs(String prevJobs);
    public void setStartDate(Date startDate);
    public void setEndDate(Date endDate);
    public void setTitle(String title);
    public void setDescription(String description);
    public void setCarAvailable(String carAvailable);
    public void setDriversLicense(String driversLicense);
    public void setWorkplace(String workplace);
    public void setSalary(Integer salary);
    public void setHomeoffice(String homeoffice);
}

