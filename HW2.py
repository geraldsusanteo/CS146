class Main:
    def __init__(self):
        pass
    
    def main(self):
        total = 10  # Total of 10 versions
        first_bad_version = self.first_bad_version(total)
        print("The first bad version is:", first_bad_version)

    def is_bad_version(self, version):
        return version >= 4

    def first_bad_version(self, total):
        left = 1
        right = total
        
        while left < right:
            middle = left + (right - left) 
            
            if self.is_bad_version(middle):
                right = middle
            else:
                left = middle + 1
        
        return left

if __name__ == "__main__":
    main_instance = Main()
    main_instance.main()

