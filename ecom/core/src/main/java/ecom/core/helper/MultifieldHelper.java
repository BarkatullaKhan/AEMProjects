package ecom.core.helper;


import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class MultifieldHelper {
    private static final Logger LOG = LoggerFactory.getLogger(MultifieldHelper.class);
    private String navigationItem;
   
    private List<NastedHelper> subItems;
    public MultifieldHelper(Resource resource){
        try {
            if(StringUtils.isNotBlank(resource.getValueMap().get("navigationItem", String.class))) {
                this.navigationItem = resource.getValueMap().get("navigationItem", String.class);
            }
            

        }catch (Exception e){
            LOG.info("\n BEAN ERROR : {}",e.getMessage());
        }

    }
	public String getNavigationItem() {
		return navigationItem;
	}
	public List<NastedHelper> getSubItems() {
		return subItems;
	}
	public void setSubItems(List<NastedHelper> subItems) {
		this.subItems = subItems;
	}

   
}