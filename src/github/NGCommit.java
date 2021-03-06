/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package github;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.kohsuke.github.GHCommit;

/**
 *
 * @author Alexander Distergoft
 */
public class NGCommit {
    private final GHCommit commit;
    private final List<String> parentsSha1;
    private final List<String> childrenSha1;
    private final String owner;
    private final Date date;
    private int spaceExpanded = -1;
    private int spaceCompact = -1;
    
    boolean multi = false;
    
    public NGCommit(GHCommit commit){
        this.commit = commit;
        parentsSha1 = commit.getParentSHA1s();
        childrenSha1 = new ArrayList<>();
        owner = commit.getOwner().getFullName(); 
        date = commit.getCommitShortInfo().getCommitter().getDate();
    }
    
    public void setMulti(boolean bool)
    {
        multi = bool;
    }
    
    public boolean getMulti()
    {
        return multi;
    }
        
    public String getAuthor(){
        return commit.getCommitShortInfo().getAuthor().getName();
    }
    
    public String getOwner(){
        return owner;
    }
    
    public String getMessage(){
        return commit.getCommitShortInfo().getMessage();
    }
    
    public Date getDate(){
        return date;
    }
    
    public List<String> getParentSHA1s(){
        return parentsSha1;
    }
    
    public String getSHA1(){
        return commit.getSHA1();
    }
    
    public boolean hasChild(){
        return (childrenSha1.size() > 0);
    }      

    public List<String> getChildrenSHA1s()
    {
        return childrenSha1;
    }
    
    public void addChildSHA1(String sha1){
        childrenSha1.add(sha1);
    }
    
    public String getAvatarUrl() throws IOException{
        return commit.getAuthor().getAvatarUrl();
    }
    
    public void setExpandedSpace(int space)
    {
        this.spaceExpanded = space;
    }
    
    public int getExpandedSpace()
    {
        return spaceExpanded;
    }
    
    public void setCompactSpace(int space)
    {
        this.spaceCompact = space;
    }
    
    public int getCompactSpace()
    {
        return spaceCompact;
    }

}
