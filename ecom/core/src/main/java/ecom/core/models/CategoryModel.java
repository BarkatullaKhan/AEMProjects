package ecom.core.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import ecom.core.bean.AllCategory;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CategoryModel {
	
	@Inject
	Resource componentResource;
	
	public List<AllCategory> getCategories(){
		List<AllCategory> categoriesList=new ArrayList<AllCategory>();
		
		try {
			Resource nestedCategory=componentResource.getChild("allCategory");
			if (nestedCategory!=null) {
				for(Resource item:nestedCategory.getChildren()){
					AllCategory category=new AllCategory(item);
					categoriesList.add(category);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return categoriesList;
	}

}
