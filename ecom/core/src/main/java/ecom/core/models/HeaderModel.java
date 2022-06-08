package ecom.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import ecom.core.helper.MultifieldHelper;
import ecom.core.helper.NastedHelper;

@Model(adaptables = SlingHttpServletRequest.class,
defaultInjectionStrategy = DefaultInjectionStrategy.REQUIRED)
public class HeaderModel {
	
	
	
	@Inject

    Resource componentResource;
	
	@ValueMapValue
    @Default(values = "logopath")
    private String fileReferenceLogo;
	
	
	
	public String getFileReferenceLogo() {
		return fileReferenceLogo;
	}



	public List<MultifieldHelper> getHeader() {
        List<MultifieldHelper> items=new ArrayList<>();
        try {
            Resource itemNested=componentResource.getChild("navItems");
            if(itemNested!=null){
                for (Resource item : itemNested.getChildren()) {
                    MultifieldHelper multifieldHelper=new MultifieldHelper(item);
                    if(item.hasChildren()){
                        List<NastedHelper> subItems=new ArrayList<>();
                        Resource nastedResource=item.getChild("subItems");
                        if (nastedResource !=null) {
                        	for(Resource nasted : nastedResource.getChildren()){
                            	subItems.add(new NastedHelper(nasted));
                            }
						}
                        multifieldHelper.setSubItems(subItems);
                    }
                    items.add(multifieldHelper);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
       
        return items;
    }
	

}
