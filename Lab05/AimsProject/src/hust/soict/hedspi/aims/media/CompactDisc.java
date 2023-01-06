package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks =
        new ArrayList<Track>();
    
    public String getArtist() {
		return artist;
	}

	public CompactDisc(int id, String title, String director, int length) {
        super(id, title, director, length);
    }

    public CompactDisc(int id, String title, String category,  String director, int length, float cost, String artist,
			List<Track> tracks) {
        super(id, title, category, director, length, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

	public CompactDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director, length, cost);
	}

	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.printf("The track has been added successfully\n");
		} else {
			System.out.println("The track is already in list of this tracks!");
		}
	}

	public void removetrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.printf("The track has been removed successfully\n");
		} else {
			System.out.println("The track is not already in list of tracks!");
		}
	}

    public int getLength() {
        int sumLength = 0;
        for (Track track : tracks) {
            sumLength += track.getLength();
        }
        return sumLength;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            for (Track track : tracks) {
                track.play();
                System.out.println("===============");
            }
            java.util.Iterator iter = tracks.iterator();
            Track nexTrack;
            while (iter.hasNext()) {
                nexTrack = (Track) iter.next();
                try {
                    nexTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }
}
