package com.opclss.watchlist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WacthlistController {

    List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();
    int index = 1;

    @GetMapping("/watchlist")
    public ModelAndView getWatchlist(){



        String viewName = "watchlist";

        Map<String,Object> model = new HashMap<String,Object>();

        model.put("watchlistItems", watchlistItems);
        model.put("numberOfMovies",watchlistItems.size());
        // model.put("numberOfMovies","1234");

        return new ModelAndView(viewName,model);

    }

    @GetMapping("/watchListItemForm")
    public ModelAndView ShowWatchListItemForm(){

        String viewName = "watchlistItemForm";

        Map<String,Object> model = new HashMap<String,Object>();

        model.put("WatchListItem", new WatchlistItem());

        return new ModelAndView(viewName,model);
    }

    @PostMapping("/watchlistItemForm")
    public ModelAndView submitWatchlistItemForm(WatchlistItem watchlistItem) {

        watchlistItem.setId(index++);
        watchlistItems.add(watchlistItem);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/watchlist");

        return new ModelAndView(redirectView);
    }

}