package conferenceRooomAvailability;

import java.util.List;

public class Room {

	private List<Interval> availableSlots;

	public Room(List<Interval> avalibaleSlots) {
		this.availableSlots = avalibaleSlots;
	}

	public List<Interval> getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(List<Interval> availableSlots) {
		this.availableSlots = availableSlots;
	}

	public boolean isAvailable(Interval interval) {
		for(Interval slot:availableSlots){
			if(slot.getStart()<=interval.getStart() && slot.getEnd()>=interval.getEnd()){
				return true;
			}
		}
		return false;
	}

	public boolean isAvailableUsingBinarySearch(Interval interval) {
		return isAvailable(interval,0,availableSlots.size()-1);
	}

	private boolean isAvailable(Interval interval, int startIndex, int endIndex) {
		if(startIndex==endIndex){
			Interval slot = availableSlots.get(startIndex);
			return (interval.getStart()>=slot.getStart() && interval.getEnd()<=slot.getEnd());
		}
		int mid=(startIndex+endIndex)/2;
		Interval slot = availableSlots.get(mid);
		if(interval.getStart()>=slot.getStart() && interval.getEnd()<=slot.getEnd()){
			return true;
		}
		if(interval.getStart()<slot.getStart()){
			return isAvailable(interval, startIndex,mid-1);
		}
		return isAvailable(interval, mid+1, endIndex);
	}
	
	public boolean isAvailableUsingBinarySearchIteration(Interval interval){
		int startIndex=0;
		int endIndex=availableSlots.size()-1;
		Interval slot;
		while(startIndex<=endIndex){
			int mid=(startIndex+endIndex)/2;
			slot = availableSlots.get(mid);
			if(interval.getStart()>=slot.getStart() && interval.getEnd()<=slot.getEnd()){
				return true;
			}
			if(interval.getStart()<slot.getStart()){
				endIndex=mid-1;
			}else{
				startIndex=mid+1;
			}
		}
		return false;
	}
}
