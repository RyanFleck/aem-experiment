package com.mnp.rcf.aem.experiment.core;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;

import com.mnp.rcf.aem.experiment.core.HeroTextBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class HeroTextComponent extends WCMUsePojo {

    /** The hero text bean. */
    private HeroTextBean heroTextBean = null;

    @Override
    public void activate() throws Exception {

        Node currentNode = getResource().adaptTo(Node.class);

        heroTextBean = new HeroTextBean();

        if (currentNode.hasProperty("jcr:Heading")) {
            heroTextBean.setHeadingText(currentNode.getProperty("./jcr:Heading").getString());
        }
        if (currentNode.hasProperty("jcr:description")) {
            heroTextBean.setDescription(currentNode.getProperty("./jcr:description").getString());
        }

    }

    public HeroTextBean getHeroTextBean() {
        return this.heroTextBean;
    }
}