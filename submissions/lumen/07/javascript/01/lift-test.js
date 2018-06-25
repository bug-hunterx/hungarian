describe('Lift cruising', function () {
    it('should be lonely after 8 stops at 0 floor', function () {
        expect(f('4:2|1:5|2:0\n1:1|2:0\n2:0\n1:0\n1:5|3:6|1:0\n1:1|1:3|2:5', 11)).toEqual('lonely after 8 stops at 0 floor');
    });

    it('should be polite after 3 stops at 1 floor', function () {
        expect(f('1:0|1:1\n3:2|5:0\n1:1|2:2', 6)).toEqual('polite after 3 stops at 1 floor');
    });

    it('should be polite lonely after 4 stops at 0 floor', function () {
        expect(f('2:1|3:2\n1:0|1:1\n3:2|5:0\n1:1|2:2', 10)).toEqual('lonely after 4 stops at 0 floor');
    });

    it('should be polite after 7 stops at 5 floor', function () {
        expect(f('2:2|1:5\n3:8|1:0\n4:2|1:5|2:0\n1:1|2:0|4:2\n2:0|2:7\n1:0|1:8\n1:5|3:6|1:0\n1:1|1:3|2:5', 9)).toEqual('polite after 7 stops at 5 floor');
    });

    it('should be polite after 0 stops at 0 floor', function () {
        expect(f('2:2|1:5\n3:8|1:0\n4:2|1:5|2:0\n1:1|2:0|4:2\n2:0|2:7\n1:0|1:8\n1:5|3:6|1:0\n1:1|1:3|2:5', 2)).toEqual('polite after 0 stops at 0 floor');
    });
    
    it('should be polite after 1 stops at 5 floor', function () {
        expect(f('2:0\n\n\n\n1:5', 2)).toEqual('polite after 1 stops at 5 floor');
    });

    it('should be lonely after 8 stops at 0 floor', function () {
        expect(f('1:3\n1:5|1:2\n1:3|1:1\n1:2|1:0\n1:1', 2)).toEqual('lonely after 8 stops at 0 floor');
    });

    it('should be polite after 0 stops at 0 floor', function () {
        expect(f('1:0|1:1\n1:3|5:5|2:0\n\n3:2|5:0\n1:1|2:2', 2)).toEqual('polite after 0 stops at 0 floor');
    });

});
