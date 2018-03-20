public class Operator
{
    MemberRecords memberRecords;
    ProviderRecords providerRecords;

    public void insertMember(Member member)
    {
    	memberRecords.getMemberDetails.add(member);
    }
    
    public void insertProvider(Provider provider)
    {
    	providerRecords.getProviderDetails.add(provider);
    }
    
    public void removeMember(Member member)
    {
    	memberRecords.getMemberDetails.remove(member);
    }
    
    public void removeProvider(Provider provider)
    {
    	providerRecords.getProviderDetails.remove(provider);
    }
    
    public void updateMemberDetails(Member member)
    {
    	
    }
    
    public void updateProviderDetails(Provider provider)
    {
    	
    }
}