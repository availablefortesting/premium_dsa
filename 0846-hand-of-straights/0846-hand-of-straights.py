class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        freq = Counter(hand)
        
        for card in sorted(hand):
            if freq[card] > 0:
                start_card_freq = freq[card]
                for next_card in range(card, card + groupSize):
                    freq[next_card] -= start_card_freq
                    
                    if freq[next_card] < 0:
                        return False
        return True