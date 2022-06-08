package ecom.core.helper;


import org.apache.sling.api.resource.Resource;

public class NastedHelper {
    private String subItem;
    
    public NastedHelper(Resource resource){
        if(resource.getValueMap().get("subItem", String.class)!=null) {
            this.subItem = resource.getValueMap().get("subItem", String.class);
        }
       

    }

	public String getSubItem() {
		return subItem;
	}
    

   
}