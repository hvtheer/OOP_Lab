package hust.soict.hedspi.aims.media;
import java.util.List;
import java.util.ArrayList;

public class CompactDisc extends Media implements Playable{
	private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    
    public boolean addTrack(Track newTrack) {
        if(tracks.contains(newTrack)){
            return false;
        } else {
            tracks.add(newTrack);
            return true;
        }
    }

    public boolean removeTrack(Track track) {
        if(tracks.contains(track)){
            tracks.remove(track);
            return true;
        } else {
            return false;
        }
    }

    public int getLength(){
        int total = 0;
        for (Track i : tracks) {
            total += i.getLength();
          }
        return total;
    }
    
    @Override
    public void play() {
        System.out.println("Artist: " + artist);
        for (Track i : tracks) {
            i.play();
        }
    }
}
