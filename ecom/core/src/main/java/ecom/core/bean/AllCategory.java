package ecom.core.bean;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AllCategory {
	
	 private static final Logger LOG = LoggerFactory.getLogger(AllCategory.class);
	 private String categoryName;
	 private String imagePath;

	public AllCategory(Resource resource) {
		try {
			if (StringUtils.isNotBlank(resource.getValueMap().get("categoryName",String.class))) {
				this.categoryName=resource.getValueMap().get("categoryName",String.class);
			}
			if (StringUtils.isNotBlank(resource.getValueMap().get("imagePath",String.class))) {
				this.imagePath=resource.getValueMap().get("imagePath",String.class);
			}
		} catch (Exception e) {
			LOG.error(e.toString());
		}
	}

	
	public String getCategoryName() {
		return categoryName;
	}

	public String getImagePath() {
		return imagePath;
	}
	
	
	
	

		
}
