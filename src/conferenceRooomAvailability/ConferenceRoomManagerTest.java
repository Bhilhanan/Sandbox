package conferenceRooomAvailability;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConferenceRoomManagerTest {

	private List<Room> conferenceRooms;
	private List<Interval> availableSlots;

	private ConferenceRoomManager manager;

	@Before
	public void init() {
		conferenceRooms = new ArrayList<>();

		availableSlots = new ArrayList<>();
		availableSlots.add(new Interval(1, 2));
		availableSlots.add(new Interval(3, 4));
		availableSlots.add(new Interval(5, 6));
		conferenceRooms.add(new Room(availableSlots));

		availableSlots = new ArrayList<>();
		availableSlots.add(new Interval(1, 2));
		availableSlots.add(new Interval(5, 6));
		conferenceRooms.add(new Room(availableSlots));

		availableSlots = new ArrayList<>();
		availableSlots.add(new Interval(3, 4));
		conferenceRooms.add(new Room(availableSlots));

		manager = new ConferenceRoomManager(conferenceRooms);
	}

	@Test
	public void shouldCountConferenceRooms() {
		long startTime = System.currentTimeMillis();
		int countAvailableRooms = manager.countAvailableRooms(new Interval(3, 4));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(startTime + "," + endTime + "," + totalTime);
		Assert.assertEquals(2, countAvailableRooms);
	}

	@Test
	public void shouldCountConferenceRoomsUsingBinarySearchRecursion() {
		long startTime = System.currentTimeMillis();
		int countAvailableRooms = manager.countAvailableRoomsBinarySearchRecursion(new Interval(3, 4));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(startTime + "," + endTime + "," + totalTime);
		Assert.assertEquals(2, countAvailableRooms);
	}

	@Test
	public void shouldCountConferenceRoomsUsingBinarySearchIeration() {
		long startTime = System.currentTimeMillis();
		int countAvailableRooms = manager.countAvailableRoomsBinarySearchIteration(new Interval(3, 4));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(startTime + "," + endTime + "," + totalTime);
		Assert.assertEquals(2, countAvailableRooms);
	}
}
