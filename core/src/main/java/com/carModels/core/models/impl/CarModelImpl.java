package com.carModels.core.models.impl;
import com.carModels.core.models.CarModel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

@Model (adaptables = SlingHttpServletRequest.class,
        adapters = CarModel.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CarModelImpl implements CarModel {

      private static final Logger LOG = LoggerFactory.getLogger(CarModelImpl.class);

      @ResourcePath(path="/content/car-models/us/en/jcr:content/root/container/container/carmodel")
       Resource componentResource ;

        @ValueMapValue(name="title", via = "resource")
        private String title;

        @ValueMapValue(name = "text",  via = "resource")
        private String text;

        @ValueMapValue(name = "bottomtext", via = "resource")
        private String bottomtext;

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getText() {
            return text;
        }

       @Override
        public List<Map<String, String>> getCarModels() {
        List<Map<String, String>> modelDetails = new ArrayList<>();
        try {
            Resource modelDetail = componentResource.getChild("carmodeldetails");

            if(modelDetail!= null)
            {
                for(Resource model : modelDetail.getChildren())
                {
                    Map<String, String> modelsMap = new HashMap<>();
                    modelsMap.put("modelname", model.getValueMap().get("modelname", String.class));
                    modelsMap.put("modelcount", model.getValueMap().get("modelcount",String.class));
                    modelsMap.put("modellink", model.getValueMap().get("modellink", String.class));
                    modelDetails.add(modelsMap);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return modelDetails;
    }

    @Override
        public String getBottomText() {
           return bottomtext;
        }
}
