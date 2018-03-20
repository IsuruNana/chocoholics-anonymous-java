public class TransactionRecord
{
    private DateTime currentDateTime;
    private DateTime serviceDate;
    private Provider provider;
    private Member member;
    private int serviceCode;
    private String comments;
    private double fee;
    
    public TransactionRecord()
    {
        //DEFAULT CONSTRUCTOR
    }
    
    public DateTime getServiceDate()
    {
        return serviceDate;
    }
    
    public int getServiceCode()
    {
        return serviceCode;
    }
    
    public String getComments()
    {
        return comments;
    }
    
    public void getFee()
    {
        return fee;
    }
    
    public void setServiceDate(DateTime newServDate)
    {
        serviceDate = newServDate;
    }
    
    public void setProviderNumber(int num)
    {
        
    }
    
    public void setMemberNumber(int num)
    {
        
    }
    
    public void setServiceCode(int servCode)
    {
        serviceCode = servCode;
    }
    
    public void setComments(String comms)
    {
        comments = comms;
    }
    
    public void setFee(double fee)
    {
        this.fee = fee;
    }
    
  
}