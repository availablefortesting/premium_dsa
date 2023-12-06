class Solution:
    def totalMoney(self, n: int) -> int:
        full_week, remaining_days = n//7, n%7
        full_week_saving, remaining_days_saving = 0,0
        
        if full_week:
            full_week_saving = 7 * ((full_week * (full_week + 7)) // 2)
            
        if remaining_days:
            remaining_days_saving =  remaining_days * full_week + (remaining_days * (remaining_days + 1)) // 2
        
        return full_week_saving + remaining_days_saving
        