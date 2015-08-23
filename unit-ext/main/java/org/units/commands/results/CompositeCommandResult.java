package org.units.commands.results;

import org.units.commands.interceptors.CommandInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23.08.2015.
 */
public class CompositeCommandResult implements CommandResult {

    private List<CommandResult> results = new ArrayList<>();


    public void addResult(CommandResult commandResult){
        results.add(commandResult);
    }




}
