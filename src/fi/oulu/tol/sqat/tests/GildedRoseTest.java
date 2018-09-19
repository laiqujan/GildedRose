package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	// Example scenarios for testing
	// Item("+5 Dexterity Vest", 10, 20));
	// Item("Aged Brie", 2, 0));
	// Item("Elixir of the Mongoose", 5, 7));
	// Item("Sulfuras, Hand of Ragnaros", 0, 80));
	// Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
	// Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_AgedBrie_Quality_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 10));

		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(12, itemBrie.getQuality());
	}

	@Test
	public void check_AgedBrie_Quality_For10Sellin() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 11, 10));

		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(13, itemBrie.getQuality());
	}

	@Test
	public void check_AgedBrie_Quality_For3Sellin() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 5, 10));

		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(16, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay_AgedBrie_SellIn_10_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 4, 10));

		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(2, itemBrie.getSellIn());
	}

	@Test
	public void checkPeakQuality50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 12, 49));

		// Act
		store.updateEndOfDay();
		store.updateEndOfDay();

		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(50, itemBrie.getQuality());
	}

	@Test
	public void testUpdateEndOfDay() {
		fail("Test not implemented");
	}

	@Test
	public void checkSulfurasQulaity() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras", 8, 80));
		store.updateEndOfDay();
		store.updateEndOfDay();

		List<Item> items = store.getItems();
		Item itemsulf = items.get(0);
		assertEquals(80, itemsulf.getQuality());

	}

	@Test
	public void checkNegativeQuality() {
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 1, 1));

		store.updateEndOfDay();
		store.updateEndOfDay();

		List<Item> items = store.getItems();
		Item itemElixir = items.get(0);
		assertEquals(0, itemElixir.getQuality());

	}

}
