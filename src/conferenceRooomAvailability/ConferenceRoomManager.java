package conferenceRooomAvailability;

import java.util.List;

/*
 * There are n number of conference room.
 * Count the number of rooms available for a meeting with given start and end time.
 * Conference rooms have a List<Interval> depicting the available time intervals in sorted order.
 * An Interval object will hold start and end time
 * 
 *  n - number of conference rooms
 *  m - number of available intervals of a conference room 
 */
public class ConferenceRoomManager {
	private List<Room> conferenceRooms;

	public ConferenceRoomManager(List<Room> conferenceRooms){
		this.conferenceRooms=conferenceRooms;
	}
	
	public int countAvailableRooms(Interval interval){
		int count=0;
		for(Room room:conferenceRooms){
			if(room.isAvailable(interval)){
				count++;
			}
		}
		return count;
	}

	public int countAvailableRoomsBinarySearchRecursion(Interval interval) {
		int count=0;
		for(Room room:conferenceRooms){
			if(room.isAvailableUsingBinarySearch(interval)){
				count++;
			}
		}
		return count;
	}

	public int countAvailableRoomsBinarySearchIteration(Interval interval) {
		int count=0;
		for(Room room:conferenceRooms){
			if(room.isAvailableUsingBinarySearchIteration(interval)){
				count++;
			}
		}
		return count;
	}
}
