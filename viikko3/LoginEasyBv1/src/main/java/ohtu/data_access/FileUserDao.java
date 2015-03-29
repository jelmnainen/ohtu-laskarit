/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.*;
import java.util.*;
import ohtu.domain.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author johannes
 */

@Component
public class FileUserDao implements UserDao {
    
    private String path;
    private BufferedReader reader;
    private List<User> users;
    
    public FileUserDao(String path){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist");
            System.exit(1);
        }
        try {
            this.users = getUsersFromFile();
        } catch (IOException ex) {
            System.out.println("I/O exception happened");
        }
                
    }

    @Override
    public List<User> listAll() {
        return this.users;
    }

    @Override
    public User findByName(String name) {
        for (User user : this.users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        this.users.add(user);
        String data = user.getUsername() + " " + user.getPassword() + "\n";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
            writer.write(data);
            writer.close();
        } catch (IOException ex) {
            System.out.println("I/O exception happened");
        }
        
    }

    private List getUsersFromFile() throws IOException {
        String line = this.reader.readLine();
        ArrayList<User> users = new ArrayList();
        while(line != null){
            String[] userdata = line.split(" ");
            users.add(new User(userdata[0], userdata[1]));
        }
        return users;
    }
    
}
