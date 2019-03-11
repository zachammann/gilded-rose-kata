describe("Gilded Rose", function() {

  it("should foo", function() {
    var items = update_quality([ new Item("foo", 0, 0) ]);
    expect(items[0].name).toEqual("fixme");
  });

});
