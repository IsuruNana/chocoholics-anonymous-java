public class BillChocAn
{
    private int serviceCode;
    private DateTime serviceDate;
    private DateTime transactionTime;
    private Member theMember;
    private double fee;
    private TransactionRecord theRecord;
    
    public BillChocAn()
    {
        //DEFAULT CONSTRUCTOR
    }
    
    public void setServiceCode(int servCode)
    {
        serviceCode = servCode;
    }
    
    public bool checkValidCode(int correctCode)
    {
        return serviceCode == correctCode;
    }
    
    public bool verifyServiceName()
    {
        
    }
    
    public void inputComments(String comments)
    {
        theRecord.setComments(comments);
    }
    
    public void inputCurrentDateTime(DateTime dateTime)
    {
        serviceDate = dateTime;
    }
    
    public void inputMemberName()
    {
        
    }
    
    public void inputMemberPIN(int pin)
    {
        member.setPIN(pin);
    }
    
    public double lookupFee()
    {
        return fee;
    }
    
    public void printFee()
    {
        System.out.println(fee);
    }
    
    public TransactionRecord getRecord()
    {
        return theRecord;
    }
    
    public void initiateDirectory()
    {
        
    }  
}