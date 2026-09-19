class Solution(object):
    def checkOverlap(self, radius, xCenter, yCenter, x1, y1, x2, y2):
        cx = max(x1, min(xCenter, x2))
        cy = max(y1, min(yCenter, y2))
        dx, dy = xCenter - cx, yCenter - cy
        return dx * dx + dy * dy <= radius * radius